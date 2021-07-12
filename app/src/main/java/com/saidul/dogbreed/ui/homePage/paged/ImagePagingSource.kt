package com.saidul.dogbreed.ui.homePage.paged

import androidx.paging.PagingSource
import com.saidul.dogbreed.data.model.BreedsItem
import com.saidul.dogbreed.data.model.ImagesResponseItem
import com.saidul.dogbreed.data.repository.Repository


class ImagePagingSource(private val repository: Repository, private val value: BreedsItem?) :
    PagingSource<Int, ImagesResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesResponseItem> {
        return try {

            val nextPage = params.key ?: 1
            val movieListResponse = repository.images(10, nextPage, value?.id ?: 0)
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
