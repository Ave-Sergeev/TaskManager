package daos

import cats.effect.IO
import models.User

class UserDAO {

  def findUsers: IO[User] = ???

  def findTaskById: IO[User] = ???
}
