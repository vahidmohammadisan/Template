package ir.vahidmohammadisan.basic_feature.presentation.mapper

import ir.vahidmohammadisan.basic_feature.domain.model.Rocket
import ir.vahidmohammadisan.basic_feature.presentation.model.RocketDisplayable
import java.time.format.DateTimeFormatter

private const val TONNE = 1_000
private const val MILLION = 1_000_000

fun Rocket.toPresentationModel() = RocketDisplayable(
    id = id,
    name = name,
    costPerLaunchInMillions = costPerLaunch / MILLION,
    firstFlightDate = firstFlight.format(DateTimeFormatter.ISO_LOCAL_DATE),
    heightInMeters = height,
    weightInTonnes = weight / TONNE,
    wikiUrl = wikiUrl,
    imageUrl = imageUrl,
)
