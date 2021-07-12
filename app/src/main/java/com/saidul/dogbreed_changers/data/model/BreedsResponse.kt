package com.saidul.dogbreed_changers.data.model

import com.google.gson.annotations.SerializedName

data class BreedsResponseItem(

	@field:SerializedName("life_span")
	val lifeSpan: String? = null,

	@field:SerializedName("breed_group")
	val breedGroup: String? = null,

	@field:SerializedName("temperament")
	val temperament: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("weight")
	val weight: Weight? = null,

	@field:SerializedName("bred_for")
	val bredFor: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("reference_image_id")
	val referenceImageId: String? = null,

	@field:SerializedName("height")
	val height: Height? = null,

	@field:SerializedName("history")
	val history: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("origin")
	val origin: String? = null
)






