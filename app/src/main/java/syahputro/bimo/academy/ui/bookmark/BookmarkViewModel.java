package syahputro.bimo.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import java.util.List;

import syahputro.bimo.academy.data.CourseEntity;
import syahputro.bimo.academy.utils.DataDummy;

public class BookmarkViewModel extends ViewModel {

    List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}

