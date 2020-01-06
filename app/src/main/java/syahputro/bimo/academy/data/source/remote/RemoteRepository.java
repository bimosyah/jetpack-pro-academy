package syahputro.bimo.academy.data.source.remote;

import java.util.List;

import syahputro.bimo.academy.data.source.remote.response.ContentResponse;
import syahputro.bimo.academy.data.source.remote.response.CourseResponse;
import syahputro.bimo.academy.data.source.remote.response.ModuleResponse;
import syahputro.bimo.academy.utils.JsonHelper;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public List<CourseResponse> getAllCourses() {
        return jsonHelper.loadCourses();
    }

    public List<ModuleResponse> getModules(String courseId) {
        return jsonHelper.loadModule(courseId);
    }

    public ContentResponse getContent(String moduleId) {
        return jsonHelper.loadContent(moduleId);
    }
}
