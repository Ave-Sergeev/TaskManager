package models

case class Task(
  id: Long,
  userId: Long,
  text: String,
  done: Boolean,
  deleted: Boolean
)