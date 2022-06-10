package daos

import cats.effect.IO
import models.Task

class TaskDAO {

  def findTasks: IO[Task] = ???

  def findTaskById: IO[Task] = ???
}
