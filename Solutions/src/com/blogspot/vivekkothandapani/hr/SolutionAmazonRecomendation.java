package com.blogspot.vivekkothandapani.hr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionAmazonRecomendation {

	static int[] determineRecommendation(String itemId, String[] purchases) {
		HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for (String s : purchases) {
			String p[] = s.split(":");
			ArrayList<String> items = m.get(p[0]);
			if (items == null) {
				items = new ArrayList<String>();
				items.add(p[1]);

			} else {
				items.add(p[1]);
			}
			m.put(p[0], items);
		}

		Set<String> strong = new HashSet<String>();
		Set<String> weak = new HashSet<String>();
		Set<String> temp = new HashSet<String>();

		Iterator it = m.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			ArrayList<String> items = (ArrayList<String>) pair.getValue();
			if (items.contains(itemId)) {
				strong.addAll(items);
				temp.add((String) pair.getKey());
			}
			if (items.size() == 1) {
				temp.add((String) pair.getKey());
			}
		}
		strong.remove(itemId);
		for (String s : temp) {
			m.remove(s);
		}

		int strongCount = strong.size();
		int weakCount = 0;
		int[] out = { strongCount, weakCount };

		weak.addAll(strong);
		while (m.size() > 0) {
			temp = new HashSet<String>();
			it = m.entrySet().iterator();

			boolean noMatch = true;
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				ArrayList<String> items = (ArrayList<String>) pair.getValue();
				for (String s : items) {
					if (weak.contains(s)) {
						noMatch = false;
						weak.addAll(items);
						temp.add((String) pair.getKey());
						break;
					}
				}
			}
			if (noMatch) {
				break;
			}
			;
			for (String s : temp) {
				m.remove(s);
			}
		}

		weak.removeAll(strong);
		out[1] = weak.size();

		return out;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int[] res;
		String _itemId;
		try {
			_itemId = in.nextLine();
		} catch (Exception e) {
			_itemId = null;
		}

		int _purchases_size = 0;
		_purchases_size = Integer.parseInt(in.nextLine());
		String[] _purchases = new String[_purchases_size];
		String _purchases_item;
		for (int _purchases_i = 0; _purchases_i < _purchases_size; _purchases_i++) {
			try {
				_purchases_item = in.nextLine();
			} catch (Exception e) {
				_purchases_item = null;
			}
			_purchases[_purchases_i] = _purchases_item;
		}

		res = determineRecommendation(_itemId, _purchases);
		for (int res_i = 0; res_i < res.length; res_i++) {
			System.out.println(String.valueOf(res[res_i]));

		}

	}
}
