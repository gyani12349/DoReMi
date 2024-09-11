package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.geektrust.command.commandInvoker;
import com.example.geektrust.exceptions.noCommandFound;

public class App {

	public static void main(String[] args) {

		BufferedReader reader;
		String inputFile = "./sample_input/input1.txt";
		commandInvoker invoker = new commandInvoker();

		try{
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();

			while(line != null){

				List<String> inputCommands = Arrays.asList(line.split(" "));
				invoker.execute(inputCommands);
				line = reader.readLine();

			}

			reader.close();

		}catch(IOException  | noCommandFound e){

			System.out.println(e.getMessage());
			e.printStackTrace();
            
		}
	}
}