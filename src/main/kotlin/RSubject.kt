import data.Student
import react.*
import react.dom.h1

interface RSubjectProps : RProps {
    var title: String
    var students: Array<Student>
}

interface RSubjectState : RState {
    var present: Array<Boolean>
}

class RSubject : RComponent<RSubjectProps, RSubjectState>() {
    override fun componentWillMount() {
        state.apply {
            present = Array(props.students.size) { false }
        }
    }

    private val onClickStudent = { index: Int ->
        setState {
            present[index] = !present[index]
        }
    }

    override fun RBuilder.render() {
        h1 {
            +props.title
        }
        rstudentList(props.students, state.present, onClickStudent)
    }
}

fun RBuilder.rsubject(title: String, students: Array<Student>) =
    child(RSubject::class) {
        attrs.title = title
        attrs.students = students
    }