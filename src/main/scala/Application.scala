
import scala.concurrent.ExecutionContext

import cats.effect.{ExitCode, IO, IOApp}
import daos.{TaskDAO, UserDAO}
import endpoints.AppEndpoint
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder
import services.{TaskService, UserService}

object Application extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {

    implicit val ex: ExecutionContext = ExecutionContext.global

    val apis = Router(
      "/api" -> new AppEndpoint[IO](new UserService(new UserDAO), new TaskService(new TaskDAO)).endpoints
    ).orNotFound

    BlazeServerBuilder[IO](ex)
      .bindHttp(8080, "localhost")
      .withHttpApp(apis)
      .serve
      .compile
      .drain
      .map(_ => ExitCode.Success)
  }
}
