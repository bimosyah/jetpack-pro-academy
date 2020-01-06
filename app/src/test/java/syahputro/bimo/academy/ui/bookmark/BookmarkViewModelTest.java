package syahputro.bimo.academy.ui.bookmark;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import syahputro.bimo.academy.data.CourseEntity;
import syahputro.bimo.academy.data.source.AcademyRepository;
import syahputro.bimo.academy.utils.FakeDataDummy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookmarkViewModelTest {
    private BookmarkViewModel viewModel;
    private AcademyRepository academyRepository = mock(AcademyRepository.class);

    @Before
    public void setUp() {
        viewModel = new BookmarkViewModel(academyRepository);
    }

    @Test
    public void getBookmark() {
        when(academyRepository.getBookmarkedCourses()).thenReturn(FakeDataDummy.generateDummyCourses());
        List<CourseEntity> courseEntities = viewModel.getBookmarks();
        verify(academyRepository).getBookmarkedCourses();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}