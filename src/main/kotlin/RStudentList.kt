import data.Student
import react.*
import react.dom.li
import react.dom.ol


interface RStudentListProps : RProps {
    var students: Array<Student>
    var present: Array<Boolean>
    var onClick: (Int) -> Unit
}

val RFStudentList =
    functionalComponent<RStudentListProps> {
        ol {
            it.students.mapIndexed { index, student ->
                li {
                    rstudent(student, it.present[index]) { _ ->
                        it.onClick(index)
                    }
                }
            }
        }
    }

fun RBuilder.rstudentList(students: Array<Student>, present: Array<Boolean>, onClick: (Int) -> Unit) =
    child(RFStudentList) {
        attrs.students = students
        attrs.present = present
        attrs.onClick = onClick
    }
