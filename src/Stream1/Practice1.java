package Stream1;

import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Practice1 {
	public static void main(String[] args) {
		List<String> l1 = Stream.of("ab", "bc", "cd", "de").filter(i->i.contains("cd")).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println();
		
		List<String> l1a = Arrays.asList("a","b","c", "d");
		l1a.stream().forEach(System.out::print);
		System.out.println();
		l1a.stream().forEach(i->System.out.println(i));
		System.out.print(l1a.stream().collect(Collectors.toList())+ " ");
		Optional<String> anyElement = l1a.stream().findAny();
		System.out.println(anyElement);
		System.out.println(l1a.stream().skip(5).collect(Collectors.toList()));
		System.out.println();
		
		Stream<String> s3 = Stream.of("abc","bcd","cde","def").skip(1).map(i->i.substring(0,2));
		s3.forEach(i->System.out.print(i+" "));
		System.out.println("\n");
		
		Stream<Integer> s4 = Stream.of(1,2,3,4);
		Stream<Integer> app = Stream.concat(s4,  Stream.of(5,6));
		app.forEach(System.out::print);
		System.out.println();
		int j=-9;
		Stream<Integer> prep = Stream.concat(Stream.of(j,0), Stream.of(1,2,3,5));
		prep.forEach(System.out::print);
		
		System.out.println();
		Stream<Object> s5 = Arrays.asList().stream();
		Integer last = (Integer) s5.reduce((f,s)->s).orElse(-1);
		System.out.println(last);
		System.out.println();
		
		Stream<Integer> s6 = Stream.of(1,2,2,3,3,3,4,5,6,6,6,6,7);
		Set<Integer> set1 = s6.collect(Collectors.toSet());
		System.out.println(set1);
		
		List<String> list = Arrays.asList("ab1","ab2","ab3");
		Stream<String> stream = list.stream().filter(i ->i.contains("2"));
		stream.forEach(System.out::println);
		System.out.println();
		
		Optional<Integer> red1 = IntStream.rangeClosed(1,4).boxed().reduce((a,b) -> a-b);
		System.out.println(red1);
		
		int red2 = IntStream.rangeClosed(1,4).boxed().reduce(10, (a,b)->a-b);
		System.out.println(red2);
		
		Optional<Integer> red3 = Arrays.asList(1,2,3,4).parallelStream().reduce((a,b)->a+b);
		System.out.println(red3);
		System.out.println();
		
		IntPredicate isOdd = i->i%2==1;
		System.out.println(isOdd.test(9));
		System.out.println(isOdd.test(4));
		System.out.println();
		
		List<Integer> l7 = IntStream.rangeClosed(1, 10).filter(isOdd).boxed().collect(Collectors.toList());
		System.out.println(l7);
		System.out.println();
		
		IntStream s9 = IntStream.iterate(1, i->i+1).limit(20);
		s9.forEach(System.out::print);
		IntStream s10 = IntStream.generate(()->(int)Math.random()*10).limit(5);
		s10.forEach(System.out::println);
		System.out.println();
		
		int[] arr = IntStream.rangeClosed(1, 4).toArray();
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		IntStream s11 = IntStream.range(1, 5);
		List<Integer> l2 = s11.boxed().collect(Collectors.toList());
		System.out.println(l2);
		
		Stream<String> s13 = Stream.of("a", "b","c","d");
		System.out.println(s13.collect(Collectors.joining(",", "{", "}")));
		System.out.println();
		
		Stream<Integer> s14 = Stream.of(1,2,3,4,5);
		Stream<Integer> s15 = Stream.of(4,5,6,7,8);
		Stream<Integer> s16 = Stream.concat(s14,s15);
		List<Integer> l4 = s16.collect(Collectors.toList());
		l4.stream().distinct().forEach(System.out::print);
		System.out.println();
		System.out.println(l4.stream().collect(Collectors.toSet()));
		
		List<Integer> l4a = Arrays.asList(3,5,2,5,1,0);
		l4a.stream().sorted().forEach(System.out::println);
		l4a.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println(l4a.stream().collect(Collectors.toCollection(LinkedList::new)));
		
		Stream<String> s18 = Stream.of("one","two","three","four");
		Stream<String> s18a = Stream.of("one","two","three","four");
		boolean b1 = s18.anyMatch(i->i.contains("three"));
		boolean b2 = s18a.anyMatch(i->i.contains("five"));
		System.out.println(b1 + " " + b2);
		System.out.println();
		
		Stream<String> s19 = Stream.of("Aa","Bb","Cc","Bd","Ab","Ac");
		Predicate<String> startWithA = s->s.startsWith("A");
		Predicate<String> startWithB = s->s.startsWith("B");
		Predicate<String> notContainsC = s->!s.contains("c");
		List<String> l5 = s19.filter(startWithA.or(notContainsC).and(startWithB)).collect(Collectors.toList());
		System.out.println(l5);
		System.out.println();
		
		Stream<Integer> s20 = IntStream.rangeClosed(1, 10).boxed();
		List<Integer> l6 = s20.filter(n->n%2==0).map(n->n*n).collect(Collectors.toList());
		System.out.println(l6);
		
		Random rand = new Random();
		rand.ints(5, 100, 105).forEach(System.out::println);
		List<Long> ran = rand.longs(10).boxed().collect(Collectors.toList());
		System.out.println(ran);
		System.out.println();
		
		List<String> l8 = Arrays.asList("hello","how","you","doing").stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(l8);
		System.out.println();
		
		String date = "2022-07-12";
		LocalDate ld1 = LocalDate.parse(date);
		System.out.println("Date: " + ld1);
		String date2 = "12 Jul 2022";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate ld2 = LocalDate.parse(date2, dtf);
		System.out.println(ld2);
		
		Base64.Encoder encoder = Base64.getEncoder();
		String st = "ThisIsJava8";
		String encSt = encoder.encodeToString(st.getBytes());
		System.out.println(encSt);
		
		Base64.Decoder decoder = Base64.getDecoder();
		String st2 = "VGhpc0lzSmF2YTg=";
		byte[] decSt = decoder.decode(st2);
		System.out.println(new String(decSt));
		System.out.println();
		
		Path filePath = Paths.get("C:\\\\New folder", "a.txt");
		try(Stream<String> lines = Files.lines(filePath)) {
			//lines.forEach(i->System.out.print(i+"       "));
			List<String> is = lines.filter(i->i.contains("o")).collect(Collectors.toList());
			System.out.println(is);
		} catch(IOException e) {
			
		}
	}
}

