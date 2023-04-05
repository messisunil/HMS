package com.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvertedDragNDrop {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://jqueryui.com/droppable/");
		d.switchTo().frame(d.findElement(By.className("demo-frame")));

		WebElement source = d.findElement(By.id("draggable"));
		WebElement dest = d.findElement(By.id("droppable"));
		Point p=dest.getLocation();
		int xco = p.getX();
		int yco = p.getY();
		Actions a = new Actions(d);	
		a.dragAndDropBy(source, 146,18).perform();
	
		d.get("http://www.dhtmlgoodies.com/scripts/arrange-table-rows/demo.html");
		WebElement src = d.findElement(By.xpath("//tr[@id='row10']/td[@class='dg-arrange-table-rows-drag-icon']"));
		WebElement dst = d.findElement(By.xpath("//table[@id='myTable']/thead"));
		
		p=src.getLocation();
		yco=p.getY();
		
		p = dst.getLocation();
		int y = p.getY();
		
		System.out.println(xco+"  "+yco);//10 39  332 //head 39  112
		Actions b = new Actions(d);
		b.dragAndDropBy(src, 0, -(yco-y)).perform();
		Thread.sleep(5000);
		d.quit();

	}

}
