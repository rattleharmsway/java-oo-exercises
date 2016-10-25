package javagram;

import javagram.filters.*;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Javagram {
	public static String[] filters = {"BlueFilter", "RedFilter", "InvertFilter", "BrightnessFilter", "GrayScaleFilter", "MonoChromeFilter", "FlipHorizontalFilter"};

	public static void main(String[] args) throws Exception {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = "";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		Picture processed = null;
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
//				String[] relPathParts = relPath.split(File.separator); //bullshit launchCODE
//				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));  //bullshit launchCODE
				imagePath = (dir + "\\" + relPath);
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		String n = "y";
		while (n.contains("y")){
			//display filter options and prompt user for input
			int input = displayFilterMenu(in);
			
			Filter filter = getFilter(input);
			
			// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
			if (input == 4){
				System.out.println("How much do you want to modify?");
				int modify = in.nextInt();
				processed = filter.process(picture, modify, Color.white);				
			}
			else if (input == 6){
				System.out.println("What is the RED value?");
				int red = in.nextInt();
				if (red > 255)
					red = 255;
				System.out.println("What is the GREEN value?");
				int green = in.nextInt();
				if (green > 255)
					green = 255;
				System.out.println("What is the BLUE value?");
				int blue = in.nextInt();
				if (blue > 255)
					blue = 255;
				processed = filter.process(picture, 0, new Color(red, green, blue));
				
				
			}
			else{
				processed = filter.process(picture, 0, Color.white);
			}
			System.out.println("Do you want to apply another filter? enter \"y\" for yes!");
			n = in.next();
			picture = processed;


		}

		// filter and display image

		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} 
		else {
			do{
				System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving) ARE YOU SURE YOU WANT TO OVERWRITE YOUR IMAGE? :");
				fileName = in.next();
				
			}while (fileName.equals(relPath));
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int f) throws Exception {//int f
//		System.out.println(Filter.class.getInterfaces().length);
//		ArrayList<Class<? extends Filter>> ClassList = new ArrayList<Class<? extends Filter>>(2);
//		System.out.println(ClassList.toString());
//		System.out.println(filters[0] + filters[1]);
		// TODO - create some more filters, and add logic to return the appropriate one
		if (f == 1){
			return new BlueFilter();
		}
		else if (f == 2){
			return new RedFilter();
		}
		else if (f==3){
			return new InvertFilter();	
		}
		else if (f==4){
			return new BrightnessFilter();
		}
		else if (f==5){
			return new GrayScaleFilter();
		}
		else if (f==6){
			return new MonoChromeFilter();
		}
		else if (f==7){
			return new FlipHorizontalFilter();
		}
		else{
			throw new Exception("Invalid Filter Exception");
		}
	}
	
	private static int displayFilterMenu(Scanner in){
		// TODO - prompt user for filter and validate input
		int input = 100;
		do {
			try {
				
				System.out.println("Select the number of the filter you want!");
				for (int i = 0; i < filters.length; i++){
					System.out.println(i+1 + ". " + filters[i]);
				}
				input = in.nextInt();

				
			} catch (RuntimeException e) {
				System.out.println("Please select a valid Filter: ");
			}
			
		} while(input < 1  || input > filters.length);
		return input;
	}

}