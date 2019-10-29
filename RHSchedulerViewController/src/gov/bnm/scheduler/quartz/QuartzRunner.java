package gov.bnm.scheduler.quartz;


import gov.bnm.scheduler.utils.EmailUtils;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
/**
 *
 * @author Ramakrishna metla
 */
public class QuartzRunner {
  static Logger log = Logger.getLogger(QuartzRunner.class);
    public static final String QUARTZ_FACTORY_KEY = "org.quartz.impl.StdSchedulerFactory.KEY";
    private boolean performShutdown = true;
    private boolean waitOnShutdown = false;
    private transient Scheduler scheduler = null;

    public void init() throws Exception {
         log.info("Quartz Initializer loaded, initializing Scheduler...");
        try {
            StdSchedulerFactory factory = new StdSchedulerFactory();

            this.scheduler = factory.getScheduler();

            this.scheduler.start();
            for (String groupName : scheduler.getJobGroupNames()) {

                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.groupEquals(groupName))) {

                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();

                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();

                    log.info("[jobName] : " + jobName + " [groupName] : "
                            + jobGroup + " - " + nextFireTime);

                }

            }

        } catch (Exception e) {
            log.error("Quartz Scheduler failed to initialize: " + e.toString());
            throw new Exception(e);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                destroy();
                //sleep a while to avoid JVM from crashing
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }));
    }

    public void destroy() {
        if (!this.performShutdown) {
            return;
        }
        try {
            if (this.scheduler != null) {
                this.scheduler.shutdown(this.waitOnShutdown);
            }
        } catch (Exception e) {
            log.error("Quartz Scheduler failed to shutdown cleanly: " + e.toString());
            e.printStackTrace();
        }
       log.info("Quartz Scheduler successful shutdown.");
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final QuartzRunner server = new QuartzRunner();
        try {
            server.init();
            log.info("Server Started at " + (System.currentTimeMillis() - start) + " ms");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
