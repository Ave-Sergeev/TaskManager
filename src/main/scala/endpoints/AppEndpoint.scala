package endpoints

import cats.effect.Async
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import services.{TaskService, UserService}

class AppEndpoint[F[_] : Async](
  userService: UserService,
  taskService: TaskService
) extends Http4sDsl[F] {

  def endpoints: HttpRoutes[F] = routesHealth <+> routesUser <+> routesTask

  def routesHealth: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "health" =>
      Ok ("Жив будь")
  }

  def routesUser: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "users" =>
      NoContent()

    case GET -> Root / "users" / id =>
      NoContent()

    case POST -> Root / "users" / "add" =>
      NoContent()
  }

  def routesTask: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "tasks" =>
      NoContent()

    case GET -> Root / "tasks" / id =>
      NoContent()

    case POST -> Root / "tasks" / "create" =>
      NoContent()
  }
}
