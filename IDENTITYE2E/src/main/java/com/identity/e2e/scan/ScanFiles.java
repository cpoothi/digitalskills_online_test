package com.identity.e2e.scan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import com.identity.e2e.utils.FileDetails;
import com.identity.e2e.utils.VehicleDetails;

@Component
public class ScanFiles {

	public static List<FileDetails> fileDetailsList;
	private static final String FILE_EXT_PATTERN = "([^\\s]+(\\.(?i)(csv|xls|xlsx))$)";

	public ScanFiles() {
		fileDetailsList = new ArrayList<FileDetails>();
	}


	private void readFileDirectories(final File dir, final Pattern pattern) {
		final File[] files = dir.listFiles();
		if (files != null) {
			for (final File file : files) {
				if (file.isDirectory()) {
					readFileDirectories(file, pattern);
				} else if (pattern.matcher(file.getName()).matches()) {
					try {
						FileDetails x = getFileInformation(file.getAbsolutePath());
						fileDetailsList.add(x);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void readFileDetails(String fileDir) {
		readFileDirectories(new File(fileDir), Pattern.compile(FILE_EXT_PATTERN));
		System.out.println(fileDetailsList);
	}

	private FileDetails getFileInformation(String fileUrl) throws IOException {
		FileDetails fileInfo = new FileDetails();
		Path file = Paths.get(fileUrl);
		BasicFileAttributes basicFileAttributes = Files.getFileAttributeView(file, BasicFileAttributeView.class)
				.readAttributes();
		fileInfo.setFileName(file.getFileName().toString());
		fileInfo.setFileExtension(getFileExtension(new File(fileUrl)));
		fileInfo.setFileSize(basicFileAttributes.size());
		fileInfo.setFileMimeType(Files.probeContentType(file));
		return fileInfo;
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}

	public List<VehicleDetails> readVehiclesFromFile() {
		List<VehicleDetails> listOfVehicles=new ArrayList<VehicleDetails>();
		String csvFile = new File("").getAbsolutePath()  + "/src/test/resources/vehicleDetails.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			int count = 0;
			while ((line = br.readLine()) != null) {
				if (count != 0) {
					VehicleDetails vehicles=new VehicleDetails();
					String[] vehicleDetails = line.split(cvsSplitBy);
					vehicles.setRigistartionNumber(vehicleDetails[0]);
					vehicles.setMake(vehicleDetails[1]);
					vehicles.setColor(vehicleDetails[2]);
					listOfVehicles.add(vehicles);
				}
				count = count + 1;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("completed");
		return listOfVehicles;

	}
}
