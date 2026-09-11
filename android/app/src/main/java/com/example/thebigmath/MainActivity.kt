package com.example.thebigmath

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.thebigmath.data.CalculationManager
import com.example.thebigmath.theme.TheBigMathTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Keep screen awake: prevent device from sleeping while calculating
    window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    // Initialize and restore persistent calculation state if any
    CalculationManager.init(this)

    enableEdgeToEdge()
    setContent {
      TheBigMathTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          MainNavigation()
        }
      }
    }
  }

  override fun onUserLeaveHint() {
    super.onUserLeaveHint()
    // Triggered when user attempts to tap Home button or swipe home
    CalculationManager.onUserAttemptedHome(this)
  }

  override fun onResume() {
    super.onResume()
    CalculationManager.onActivityResumed(this)
  }

  override fun onPause() {
    super.onPause()
    CalculationManager.saveState(this)
  }

  fun pinScreen() {
    try {
      startLockTask()
    } catch (_: Exception) {
    }
  }

  fun unpinScreen() {
    try {
      val am = getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
      if (am != null && am.lockTaskModeState != ActivityManager.LOCK_TASK_MODE_NONE) {
        stopLockTask()
      }
    } catch (_: Exception) {
    }
  }
}

