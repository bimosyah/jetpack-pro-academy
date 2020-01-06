package syahputro.bimo.academy.di;

import android.app.Application;

import syahputro.bimo.academy.data.source.AcademyRepository;
import syahputro.bimo.academy.data.source.remote.RemoteRepository;
import syahputro.bimo.academy.utils.JsonHelper;

public class Injection {
    public static AcademyRepository provideRepository(Application application) {

        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return AcademyRepository.getInstance(remoteRepository);
    }
}
