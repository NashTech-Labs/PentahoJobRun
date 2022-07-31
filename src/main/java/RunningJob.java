import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.Repository;

public class RunningJob {
	public static void main(String[] args) {
		String file = "job.kjb";

		// Checking for repository
		Repository repository = null;

		try {
			KettleEnvironment.init();
			JobMeta jobmeta = new JobMeta(file, repository);
			Job job = new Job(repository, jobmeta);
			job.start();
			job.waitUntilFinished();
			if (job.getErrors() > 0) {
				System.out.println("Error Executing Job");
			}
		} catch (KettleException e) {
			e.printStackTrace();
		}
	}

}
