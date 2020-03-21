import data.studentList
import react.dom.render
import kotlin.browser.document


fun main() {
    render(document.getElementById("root")!!) {
        rsubject("ООП", studentList.toTypedArray())
    }
}
