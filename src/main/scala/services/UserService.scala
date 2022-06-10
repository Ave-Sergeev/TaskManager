package services

import cats.effect.IO
import daos.UserDAO
import models.User

class UserService(userDAO: UserDAO) {

  def getUsers: IO[User] = ???

  def getUserById: IO[User] = ???
}
