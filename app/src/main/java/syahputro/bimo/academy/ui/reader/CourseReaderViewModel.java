package syahputro.bimo.academy.ui.reader;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import syahputro.bimo.academy.data.ContentEntity;
import syahputro.bimo.academy.data.ModuleEntity;
import syahputro.bimo.academy.data.source.AcademyRepository;
import syahputro.bimo.academy.utils.DataDummy;

public class CourseReaderViewModel extends ViewModel {

    private String courseId;
    private String moduleId;
    private AcademyRepository academyRepository;

    public CourseReaderViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public ArrayList<ModuleEntity> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public ModuleEntity getSelectedModule() {
        return academyRepository.getContent(courseId, moduleId);
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }
}
