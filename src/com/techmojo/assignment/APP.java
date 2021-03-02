package com.techmojo.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class APP {

	public static void main(String[] args) {
		String fileName = "test-input.txt";
		List<Transaction> transactionList = new ArrayList<Transaction>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] input = line.split(",");
				Transaction transaction = new Transaction();
				transaction.setTransactionId(input[0]);
				transaction.setTransactionDate(input[1]);
				transaction.setTransactionTime(input[2]);
				transaction.setTransactionType(input[3]);
				transactionList.add(transaction);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HashSet<String> hashSet = new HashSet<String>();
		for (Transaction transaction : transactionList) {
			hashSet.add(transaction.getTransactionId());
		}
		System.out.println(hashSet.size());
		HashMap<String, String> resultMap = new HashMap<String, String>();
		for (String set : hashSet) {
			List<Transaction> childList = transactionList.stream().filter(t -> t.getTransactionId().equals(set))
					.collect(Collectors.toList());
			for (Transaction child : childList) {
				child.getTransactionDate();
			}
			if (childList.size() == 2) {
				LocalDateTime startTime = LocalDateTime.of(childList.get(0).getTxDate(), childList.get(0).getTxTime());
				LocalDateTime endTime = LocalDateTime.of(childList.get(1).getTxDate(), childList.get(1).getTxTime());
				long seconds = ChronoUnit.SECONDS.between(startTime, endTime) / (2 * 60);
				resultMap.put(childList.get(0).getTransactionId(), "Average Minutes : " + seconds);
			} else {
				resultMap.put(childList.get(0).getTransactionId(), "Processing ...");
			}

			//System.out.println("transcation id" + set + "size" + childList.size());

		}
		for (Map.Entry<String, String> average : resultMap.entrySet()) {
			System.out.println(average.getKey() + "  " + average.getValue());
		}

	}

}
