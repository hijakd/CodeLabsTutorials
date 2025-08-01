package com.example.u3_path3_practice2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.u3_path3_practice2.R

// Set of Material typography styles to start with
// val Typography = Typography(
//     bodyLarge = TextStyle(
//         fontFamily = Cabin,
//         fontWeight = FontWeight.Normal,
//         fontSize = 14.sp,
//         lineHeight = 24.sp,
//         letterSpacing = 0.5.sp
//     ),
//     displayLarge = TextStyle(
//         fontFamily = GermaniaOne,
//         fontWeight = FontWeight.Normal,
//         fontSize = 30.sp
//     ),
//     displayMedium = TextStyle(
//         fontFamily = GermaniaOne,
//         fontWeight = FontWeight.Bold,
//         fontSize = 20.sp
//     ),
//     displaySmall = TextStyle(
//         fontFamily = GermaniaOne,
//         fontWeight = FontWeight.Bold,
//         fontSize = 20.sp
//     ),
//     titleMedium = TextStyle(
//         fontFamily = GermaniaOne,
//         fontWeight = FontWeight.Bold,
//         fontSize = 22.sp
//     )
// )

// val provider = GoogleFont.Provider(
//     providerAuthority = "com.google.android.gms.fonts",
//     providerPackage = "com.google.android.gms",
//     certificates = R.array.com_google_android_gms_fonts_certs
// )

val bodyFontFamily = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal)
)

val displayFontFamily = FontFamily(
    Font(R.font.germaniaone_regular, FontWeight.Normal)
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)
