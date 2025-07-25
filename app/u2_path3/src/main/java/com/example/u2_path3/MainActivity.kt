package com.example.u2_path3


import java.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u2_path3.ui.theme.CodeLabsTutorialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoreApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CoreApp(modifier: Modifier = Modifier) {
    TipTimeLayout()
}

@Composable
fun TipTimeLayout(modifier: Modifier = Modifier) {

    var amountInput by rememberSaveable { mutableStateOf("") }
    var tipInput by rememberSaveable { mutableStateOf("") }
    var roundUp by rememberSaveable { mutableStateOf(false) }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercentage = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercentage, roundUp)

    Column(
        modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
        )

        EditNumberField(
            label = R.string.bill_amount,
            value = amountInput,
//            leadingIcon = R.drawable.money,
            leadingIcon = R.drawable.currency_usd,
            imeAction = ImeAction.Next,
            onValueChange = { amountInput = it },
            modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
        )

        EditNumberField(
            label = R.string.how_was_the_service,
            value = tipInput,
            leadingIcon = R.drawable.percent,
            imeAction = ImeAction.Done,
            onValueChange = { tipInput = it },
            modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
        )

        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Text(text = stringResource(R.string.tip_amount, tip), style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(@StringRes label: Int,
                    @DrawableRes leadingIcon: Int,
                    value: String,
                    imeAction: ImeAction,
                    onValueChange: (String) -> Unit,
                    modifier: Modifier = Modifier) {
    TextField(
        value = value,
        label = { Text(stringResource(label)) },
        leadingIcon = { Icon(painterResource(leadingIcon), contentDescription = null) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = imeAction),
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Composable
fun RoundTheTipRow(roundUp: Boolean, onRoundUpChanged: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
                .fillMaxWidth()
                .size(48.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(stringResource(R.string.round_up_tip))
        Switch(
            modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged
        )
    }
}

@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercentage: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercentage / 100 * amount
    if (roundUp) tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLabsTutorialsTheme {
        CoreApp()
    }
}