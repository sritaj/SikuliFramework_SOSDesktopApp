package imageLocators;

import java.util.Iterator;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This class contains the Methods that is used to interact with the UI Elements and carry out operations in the Pic Grid */


public class PC_App_PicGrid {
	
	/* Below Screen class is initialized and path to required images are stored in the Strings defined */ 
	Screen sr;
	String imageGrid = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Select Image grid.png";
	String selectImageWindow = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Select Image window.png";
	String FileNameWindow = "F://GitHub//SmartOLEDSwitch//Images//File Name Window.png";
	String openImage = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Open Window.png";
	String saveActive = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Save button.png";
	
	public PC_App_PicGrid(Screen sr) {
		this.sr = sr;
	}
	
	/* This method is to verify if the empty picture grid screen is present and returns the value */ 
	public Match getGrids() {
		Pattern image_grid = new Pattern(imageGrid);
		return sr.exists(image_grid);
	}
	
	/* This method is to verify if the File Explorer Image selection text box is present and returns the value */ 
	public Match imageGridState() throws FindFailed {
		Pattern image_grid = new Pattern(imageGrid);
		Pattern image_window = new Pattern(selectImageWindow);
		sr.click(image_grid);
		return sr.exists(image_window);
	}
	
	/* This method is to select image for a particular cell of the picture grid screen */ 
	public void selectGridImage() throws FindFailed {
		
		Pattern image_grid = new Pattern(imageGrid);
		Pattern open_image = new Pattern(openImage);
		Pattern filename_window = new Pattern(FileNameWindow);
		
		int max = 30;
		int min = 1;
		int image_number =  (int) ((Math.random()*((max-min)+1))+min);
		String getImage = Integer.toString(image_number);
		
		sr.click(image_grid);
		sr.click(filename_window);
		sr.type(getImage);
		sr.click(open_image);
		
	}

	/* This method is to select image for a particular cell of the picture grid screen */ 
	public int gridCounts() throws FindFailed {
		Pattern image_grid = new Pattern(imageGrid);
		
		Iterator<Match> gridcount = sr.findAll(image_grid);
		int count = 0;
		while(gridcount.hasNext()) {
			
			count++;
			System.out.println("Grid number " + count);
			gridcount.next();
		}	
		return count;
	}
	
	/* This method is to verify the number of cells present in the picture grid screen */ 
	public void selectAllGridImage() throws FindFailed {
		Pattern image_grid = new Pattern(imageGrid);
		Pattern open_image = new Pattern(openImage);
		Pattern filename_window = new Pattern(FileNameWindow);
		
		Iterator<Match> gridcount = sr.findAll(image_grid);
	
		int i=0;
		while(gridcount.hasNext()) {
			
			i++;
			if (i>16) {
				break;
			}
			gridcount.next().click(image_grid);
				sr.click(filename_window);
				
				int max = 30;
				int min = 1;
				int image_number =  (int) ((Math.random()*((max-min)+1))+min);
				String getImage = Integer.toString(image_number);
				
			sr.type(getImage);
			sr.click(open_image);
			sr.delayClick(1000);
		
		}		
		
			
	}
	
	/* This method is to change the image of a particular cell in the picture grid screen */ 
	public void changeGridImage() throws FindFailed {
		
		Pattern imageInGrid1 = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Image Present 1.png");
		Pattern imageInGrid2 = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Image Present 2.png");
		
		Pattern open_image = new Pattern(openImage);
		Pattern filename_window = new Pattern(FileNameWindow);
		
		int max = 30;
		int min = 1;
		int image_number =  (int) ((Math.random()*((max-min)+1))+min);
		String getImage = Integer.toString(image_number);
		
		if (sr.exists(imageInGrid1)!=null) {
			
			sr.click(imageInGrid1);
			sr.click(filename_window);
			sr.type(getImage);
			sr.click(open_image);
			sr.delayClick(1000);
				
		}else if (sr.exists(imageInGrid2)!=null) {
			sr.click(imageInGrid2);
			sr.click(filename_window);
			sr.type(getImage);
			sr.click(open_image);
			sr.delayClick(1000);
			
		}else {
			System.err.println("Unable to identify the set image in the Grid");
		}	
		
	}
	
public void selectInvalidGridImage(String image) throws FindFailed {
		
		Pattern image_grid = new Pattern(imageGrid);
		Pattern open_image = new Pattern(openImage);
		Pattern filename_window = new Pattern(FileNameWindow);
		
		sr.click(image_grid);
		sr.click(filename_window);
		sr.type(image);
		sr.click(open_image);
		
	}

}
	
	
