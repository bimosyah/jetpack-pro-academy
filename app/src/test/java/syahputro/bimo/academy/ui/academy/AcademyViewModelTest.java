package syahputro.bimo.academy.ui.academy;

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

public class AcademyViewModelTest {
    private AcademyViewModel viewModel;
    private AcademyRepository academyRepository = mock(AcademyRepository.class);

    @Before
    public void setUp() {
        viewModel = new AcademyViewModel(academyRepository);
    }

    @Test
    public void getCourses() {
        when(academyRepository.getAllCourses()).thenReturn(FakeDataDummy.generateDummyCourses());
        List<CourseEntity> courseEntities = viewModel.getCourses();
        verify(academyRepository).getAllCourses();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}