package syahputro.bimo.academy.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import syahputro.bimo.academy.R;
import syahputro.bimo.academy.data.CourseEntity;
import syahputro.bimo.academy.utils.EspressoIdlingResource;
import syahputro.bimo.academy.utils.FakeDataDummy;
import syahputro.bimo.academy.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailCourseActivityTest {

    private CourseEntity dummyCourse = FakeDataDummy.generateDummyCourses().get(0);

    @Rule
    public ActivityTestRule<DetailCourseActivity> activityRule = new ActivityTestRule<DetailCourseActivity>(DetailCourseActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailCourseActivity.class);
            result.putExtra(DetailCourseActivity.EXTRA_COURSE, dummyCourse.getCourseId());
            return result;
        }
    };

    @Test
    public void loadCourse() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyCourse.getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(String.format("Deadline %s", dummyCourse.getDeadline()))));
    }

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }


    @Test
    public void loadModules() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_module)).check(new RecyclerViewItemCountAssertion(7));
    }
}
