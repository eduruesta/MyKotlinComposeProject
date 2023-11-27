import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json
import model.Country

expect val COUNTRIES_URL:String

object CountriesRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
    suspend fun get(): List<Country> = client.request(COUNTRIES_URL).body()

}