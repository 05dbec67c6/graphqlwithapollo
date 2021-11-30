import com.apollographql.apollo.ApolloClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

private val GITHUB_GRAPHQL_ENDPOINT = "https://api.github.com/graphql"

private val httpClient: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .addNetworkInterceptor(NetworkInterceptor())
        .build()
}

val apolloClient: ApolloClient by lazy {
    ApolloClient.builder()
        .serverUrl(GITHUB_GRAPHQL_ENDPOINT)
        .okHttpClient(httpClient)
        .build()
}

private class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        return chain!!.proceed(
            chain.request().newBuilder()
                .header("Authorization", "Bearer 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").build()
        )
    }
}


