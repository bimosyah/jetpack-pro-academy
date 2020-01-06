package syahputro.bimo.academy.data.source;

import java.util.List;

import syahputro.bimo.academy.data.CourseEntity;
import syahputro.bimo.academy.data.ModuleEntity;

public interface AcademyDataSource {
    List<CourseEntity> getAllCourses();

    CourseEntity getCourseWithModules(String courseId);

    List<ModuleEntity> getAllModulesByCourse(String courseId);

    List<CourseEntity> getBookmarkedCourses();

    ModuleEntity getContent(String courseId, String moduleId);
}
