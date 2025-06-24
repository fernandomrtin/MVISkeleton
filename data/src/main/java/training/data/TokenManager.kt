package training.data

import training.network.di.TokenProvider
import android.content.Context
import android.content.SharedPreferences
import android.util.Base64
import dagger.hilt.android.qualifiers.ApplicationContext
import java.nio.charset.Charset
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(@ApplicationContext private val context: Context) :
    TokenProvider {

    companion object {
        private const val KEY_ALIAS = "keystore_token_key"
        private const val PREFS_NAME = "secure_prefs"
        private const val TOKEN_KEY = "auth_token"
        private const val TRANSFORMATION = "AES/GCM/NoPadding"
        private const val IV_SIZE = 12
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Create or get AES key stored in Keystore
     */
    private fun getOrCreateSecretKey(): SecretKey {
        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }

        return if (keyStore.containsAlias(KEY_ALIAS)) {
            val secretKeyEntry = keyStore.getEntry(KEY_ALIAS, null) as KeyStore.SecretKeyEntry
            secretKeyEntry.secretKey
        } else {
            val keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore").apply {
                init(
                    android.security.keystore.KeyGenParameterSpec.Builder(
                        KEY_ALIAS,
                        android.security.keystore.KeyProperties.PURPOSE_ENCRYPT or android.security.keystore.KeyProperties.PURPOSE_DECRYPT
                    )
                        .setBlockModes(android.security.keystore.KeyProperties.BLOCK_MODE_GCM)
                        .setEncryptionPaddings(android.security.keystore.KeyProperties.ENCRYPTION_PADDING_NONE)
                        .setKeySize(256)
                        .build()
                )
            }
            keyGenerator.generateKey()
        }
    }

    /**
     * Cypher using AES/GCM and store it in SharedPreferences
     */
    fun saveToken(token: String) {
        val cipher = Cipher.getInstance(TRANSFORMATION).apply {
            init(Cipher.ENCRYPT_MODE, getOrCreateSecretKey())
        }

        val iv = cipher.iv
        val encryptedBytes = cipher.doFinal(token.toByteArray(Charset.defaultCharset()))
        val encryptedData = iv + encryptedBytes
        val encryptedBase64 = Base64.encodeToString(encryptedData, Base64.DEFAULT)

        prefs.edit().putString(TOKEN_KEY, encryptedBase64).apply()
    }

    /**
     * Retrieve and decrypt stored token
     */
    override fun getToken(): String? {
        val encryptedBase64 = prefs.getString(TOKEN_KEY, null) ?: return null
        val encryptedData = Base64.decode(encryptedBase64, Base64.DEFAULT)

        val iv = encryptedData.copyOfRange(0, IV_SIZE)
        val encryptedBytes = encryptedData.copyOfRange(IV_SIZE, encryptedData.size)

        val cipher = Cipher.getInstance(TRANSFORMATION).apply {
            init(Cipher.DECRYPT_MODE, getOrCreateSecretKey(), GCMParameterSpec(128, iv))
        }

        return cipher.doFinal(encryptedBytes).toString(Charset.defaultCharset())
    }

    /**
     * Remove stored token
     */
    fun clearToken() {
        prefs.edit().remove(TOKEN_KEY).apply()
    }
}