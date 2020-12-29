package `in`.surajsau.trace.nintendo.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class PricesResponse(
    @JsonProperty("personalized") val personalised: Boolean,
    @JsonProperty("country") val country: String,
    @JsonProperty("prices") val prices: List<Price>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Price(
    @JsonProperty("title_id") val titleId: Long,
    @JsonProperty("sales_status") val salesStatus: String,
    @JsonProperty("regular_price") val regularPrice: GamePrice,
    @JsonProperty("discount_price") val discountedPrice: GamePrice?
)
