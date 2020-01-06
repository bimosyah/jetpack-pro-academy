package syahputro.bimo.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import java.util.List;

import syahputro.bimo.academy.data.CourseEntity;
import syahputro.bimo.academy.data.source.AcademyRepository;
import syahputro.bimo.academy.utils.DataDummy;

public class BookmarkViewModel extends ViewModel {

    private AcademyRepository academyRepository;

    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    List<CourseEntity> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }
}

