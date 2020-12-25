package `in`.surajsau.trace.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GamePrice(
    @JsonProperty("amount") val amount: String,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("raw_value") val rawValue: Int,
    @JsonProperty("start_datetime") val startDateTime: String,
    @JsonProperty("end_datetime") val endDateTime: String
)
