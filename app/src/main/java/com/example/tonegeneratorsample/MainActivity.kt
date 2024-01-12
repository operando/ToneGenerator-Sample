package com.example.tonegeneratorsample

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tonegeneratorsample.ui.theme.ToneGeneratorSampleTheme

val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 80)

val soundList = intArrayOf(
    ToneGenerator.TONE_CDMA_ABBR_ALERT,
    ToneGenerator.TONE_CDMA_ABBR_INTERCEPT,
    ToneGenerator.TONE_CDMA_ABBR_REORDER,
    ToneGenerator.TONE_CDMA_ALERT_AUTOREDIAL_LITE,
    ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,
    ToneGenerator.TONE_CDMA_ALERT_INCALL_LITE,
    ToneGenerator.TONE_CDMA_ALERT_NETWORK_LITE,
    ToneGenerator.TONE_CDMA_ANSWER,
    ToneGenerator.TONE_CDMA_CALLDROP_LITE,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_PAT3,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_PAT5,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_PAT6,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_PAT7,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING,
    ToneGenerator.TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI,
    ToneGenerator.TONE_CDMA_CONFIRM,
    ToneGenerator.TONE_CDMA_DIAL_TONE_LITE,
    ToneGenerator.TONE_CDMA_EMERGENCY_RINGBACK,
    ToneGenerator.TONE_CDMA_HIGH_L,
    ToneGenerator.TONE_CDMA_HIGH_PBX_L,
    ToneGenerator.TONE_CDMA_HIGH_PBX_SLS,
    ToneGenerator.TONE_CDMA_HIGH_PBX_SS,
    ToneGenerator.TONE_CDMA_HIGH_PBX_SSL,
    ToneGenerator.TONE_CDMA_HIGH_PBX_S_X4,
    ToneGenerator.TONE_CDMA_HIGH_SLS,
    ToneGenerator.TONE_CDMA_HIGH_SS,
    ToneGenerator.TONE_CDMA_HIGH_SSL,
    ToneGenerator.TONE_CDMA_HIGH_SS_2,
    ToneGenerator.TONE_CDMA_HIGH_S_X4,
    ToneGenerator.TONE_CDMA_INTERCEPT,
    ToneGenerator.TONE_CDMA_KEYPAD_VOLUME_KEY_LITE,
    ToneGenerator.TONE_CDMA_LOW_L,
    ToneGenerator.TONE_CDMA_LOW_PBX_L,
    ToneGenerator.TONE_CDMA_LOW_PBX_SLS,
    ToneGenerator.TONE_CDMA_LOW_PBX_SS,
    ToneGenerator.TONE_CDMA_LOW_PBX_SSL,
    ToneGenerator.TONE_CDMA_LOW_PBX_S_X4,
    ToneGenerator.TONE_CDMA_LOW_SLS,
    ToneGenerator.TONE_CDMA_LOW_SS,
    ToneGenerator.TONE_CDMA_LOW_SSL,
    ToneGenerator.TONE_CDMA_LOW_SS_2,
    ToneGenerator.TONE_CDMA_LOW_S_X4,
    ToneGenerator.TONE_CDMA_MED_L,
    ToneGenerator.TONE_CDMA_MED_PBX_L,
    ToneGenerator.TONE_CDMA_MED_PBX_SLS,
    ToneGenerator.TONE_CDMA_MED_PBX_SS,
    ToneGenerator.TONE_CDMA_MED_PBX_SSL,
    ToneGenerator.TONE_CDMA_MED_PBX_S_X4,
    ToneGenerator.TONE_CDMA_MED_SLS,
    ToneGenerator.TONE_CDMA_MED_SS,
    ToneGenerator.TONE_CDMA_MED_SSL,
    ToneGenerator.TONE_CDMA_MED_SS_2,
    ToneGenerator.TONE_CDMA_MED_S_X4,
    ToneGenerator.TONE_CDMA_NETWORK_BUSY,
    ToneGenerator.TONE_CDMA_NETWORK_BUSY_ONE_SHOT,
    ToneGenerator.TONE_CDMA_NETWORK_CALLWAITING,
    ToneGenerator.TONE_CDMA_NETWORK_USA_RINGBACK,
    ToneGenerator.TONE_CDMA_ONE_MIN_BEEP,
    ToneGenerator.TONE_CDMA_PIP,
    ToneGenerator.TONE_CDMA_PRESSHOLDKEY_LITE,
    ToneGenerator.TONE_CDMA_REORDER,
    ToneGenerator.TONE_CDMA_SIGNAL_OFF,
    ToneGenerator.TONE_CDMA_SOFT_ERROR_LITE,
    ToneGenerator.TONE_DTMF_0,
    ToneGenerator.TONE_DTMF_1,
    ToneGenerator.TONE_DTMF_2,
    ToneGenerator.TONE_DTMF_3,
    ToneGenerator.TONE_DTMF_4,
    ToneGenerator.TONE_DTMF_5,
    ToneGenerator.TONE_DTMF_6,
    ToneGenerator.TONE_DTMF_7,
    ToneGenerator.TONE_DTMF_8,
    ToneGenerator.TONE_DTMF_9,
    ToneGenerator.TONE_DTMF_A,
    ToneGenerator.TONE_DTMF_B,
    ToneGenerator.TONE_DTMF_C,
    ToneGenerator.TONE_DTMF_D,
    ToneGenerator.TONE_DTMF_P,
    ToneGenerator.TONE_DTMF_S,
    ToneGenerator.TONE_PROP_ACK,
    ToneGenerator.TONE_PROP_BEEP,
    ToneGenerator.TONE_PROP_BEEP2,
    ToneGenerator.TONE_PROP_NACK,
    ToneGenerator.TONE_PROP_PROMPT,
    ToneGenerator.TONE_SUP_BUSY,
    ToneGenerator.TONE_SUP_CALL_WAITING,
    ToneGenerator.TONE_SUP_CONFIRM,
    ToneGenerator.TONE_SUP_CONGESTION,
    ToneGenerator.TONE_SUP_CONGESTION_ABBREV,
    ToneGenerator.TONE_SUP_DIAL,
    ToneGenerator.TONE_SUP_ERROR,
    ToneGenerator.TONE_SUP_INTERCEPT,
    ToneGenerator.TONE_SUP_INTERCEPT_ABBREV,
    ToneGenerator.TONE_SUP_PIP,
    ToneGenerator.TONE_SUP_RADIO_ACK,
    ToneGenerator.TONE_SUP_RADIO_NOTAVAIL,
    ToneGenerator.TONE_SUP_RINGTONE,
);

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToneGeneratorSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(top = 24.dp)) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            toneGenerator.stopTone()
        }, modifier = modifier
            .width(200.dp)
            .height(50.dp)
    ) {
        Text(text = "Stop")
    }
    LazyColumn {
        soundList.sort()
        items(soundList.size) { index ->
            SoundList(soundList[index])
        }
    }
}


@Composable
fun SoundList(sound: Int) {
    Row(modifier = Modifier
        .fillMaxSize()
        .clickable {
            toneGenerator.startTone(sound, 200)
        }
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = sound.toString())
        }
    }
}