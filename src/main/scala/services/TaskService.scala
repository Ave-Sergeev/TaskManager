package services

import cats.effect.IO
import daos.TaskDAO
import models.Task

class TaskService(taskDAO: TaskDAO) {

  def getTasks: IO[Task] = ???

  def getTaskById: IO[Task] = ???
}