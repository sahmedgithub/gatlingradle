import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class SmokeTest extends Simulation {

  val baseUrl = "https://planets.datenkollektiv.de"

  val httpProtocol = http.baseURL(baseUrl)

  val pingScenario = scenario("PingPlanetsServer")
    .exec(http("request_planets_server_version")
      .get("/planets/server/version")
    )

  setUp(pingScenario.inject(atOnceUsers(10))).protocols(httpProtocol)
}
