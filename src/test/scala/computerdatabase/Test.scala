package computerdatabase

  import io.gatling.core.Predef._
  import io.gatling.http.Predef._
  import scala.concurrent.duration._

  class Test extends Simulation {

    val httpConf = http.baseUrl("http://mpb.folarserver.com")
      .doNotTrackHeader("1")

    val scn = scenario("BasicSimulation")
      .exec(http("request_1")
        .get("/"))
      .pause(5)

    setUp(scn.inject(atOnceUsers(1000))).protocols(httpConf)
  }
