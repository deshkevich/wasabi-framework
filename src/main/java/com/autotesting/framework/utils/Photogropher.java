package com.autotesting.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.framework.utils.WebDriverRunner;

public class Photogropher {
	private static Logger logger = LoggerFactory.getLogger(Photogropher.class);
	private static String SNAPSHOTS_FOLDER = PropertiesReader.getSnapshootPath();

	public static void doScreenshot(String caseName) {
		logger.info("Getting a snapshoot");
		String filename = getSnapshotName(caseName) + ".png";

		WebDriver driver = WebDriverRunner.getDriver();

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filename));
		} catch (IOException e) {
			logger.error(String.format(
					"Error copy screenshot file from %s to %s",
					scrFile.getAbsolutePath(), filename));
		}
	}

	public static String getSnapshotName(String driverCommand) {

		File folder = new File(SNAPSHOTS_FOLDER);
		if (!folder.exists()) {
			try {
				folder.mkdirs();
			} catch (Exception e) {
				logger.error("Cannot create folder", e);
			}
		}
		String timestamp = nowAsString("yyyyMMdd_HHmmss");
		return folder.getAbsolutePath() + "/" + timestamp + "_" + driverCommand;
	}

	public static String nowAsString(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}
}