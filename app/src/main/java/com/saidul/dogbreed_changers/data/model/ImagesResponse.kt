package com.saidul.dogbreed_changers.data.model

import com.google.gson.annotations.SerializedName

data class ImagesResponse(

	@field:SerializedName("ImagesResponse")
	val imagesResponse: List<ImagesResponseItem?>? = null
)

data class Weight(

	@field:SerializedName("metric")
	val metric: String? = null,

	@field:SerializedName("imperial")
	val imperial: String? = null
)

data class Height(

	@field:SerializedName("metric")
	val metric: String? = null,

	@field:SerializedName("imperial")
	val imperial: String? = null
)

data class BreedsItem(

	@field:SerializedName("life_span")
	val lifeSpan: String? = null,

	@field:SerializedName("breed_group")
	val breedGroup: String? = null,

	@field:SerializedName("temperament")
	val temperament: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

//	@field:SerializedName("weight")
//	val weight: Weight? = null,

	@field:SerializedName("bred_for")
	val bredFor: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("reference_image_id")
	val referenceImageId: String? = null,

//	@field:SerializedName("height")
//	val height: Height? = null
)


data class ImagesResponseItem(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

//	@field:SerializedName("breeds")
//	val breeds: List<BreedsItem?>? = null,

//	@field:SerializedName("height")
//	val height: Int? = null
)
