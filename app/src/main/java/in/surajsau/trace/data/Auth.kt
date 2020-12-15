package `in`.surajsau.trace.data

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthCredential
import com.google.firebase.auth.OAuthProvider
import java.lang.Exception
import javax.inject.Inject

class Auth @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    fun authenticate(
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
                scopes = listOf("user:email", "read:user", "read:org")
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
