package com.saidul.dogbreed_changers.ui.homePage.paged

import androidx.paging.PagingSource
import com.saidul.dogbreed_changers.data.model.ImagesResponseItem
import com.saidul.dogbreed_changers.data.repository.Repository


class InstantDeliveryPagingSource(private val repository: Repository) :
    PagingSource<Int, ImagesResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesResponseItem> {
        return try {

            val nextPage = params.key ?: 1
            val movieListResponse = repository.images(10, nextPage)
            LoadResult.Page(
                data = movieListResponse,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
