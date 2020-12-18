package `in`.surajsau.trace.data

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthCredential
import com.google.firebase.auth.OAuthProvider
import java.lang.Exception
import javax.inject.Inject

enum class AuthScope(val value: String) {
    USER(value = "user"),
    NOTIFICATION(value = "notifications"),
    READ_ORG(value = "read:org");
}

interface Auth {

    fun authenticate(activity: Activity, onSuccess: (OAuthCredential) -> Unit, onFailure: (Exception) -> Unit)
}

class AuthImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : Auth {

    override fun authenticate(
        activity: Activity,
        onSuccess: (OAuthCredential) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val pendingAuth = firebaseAuth.pendingAuthResult
        if (pendingAuth != null) {
            pendingAuth
                .addOnSuccessListener {
                    (it.credential as? OAuthCredential)?.let(onSuccess) ?: onFailure(Exception("Invalid data"))
                }
                .addOnFailureListener(onFailure)
        } else {
            val provider = OAuthProvider.newBuilder("github.com").apply {
                scopes = listOf(AuthScope.USER, AuthScope.READ_ORG, AuthScope.NOTIFICATION)
                    .map { it.value }
            }

            firebaseAuth
                .startActivityForSignInWithProvider(activity, provider.build())
                .addOnSuccessListener {
                    (it.credential as? OAuthCredential)?.let(onSuccess) ?: onFailure(Exception("Invalid data"))
                }
                .addOnFailureListener(onFailure)
        }
    }
}
