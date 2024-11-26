# combin: Binary Combiner

`combin` is a Java utility to generate all possible binary combinations of a given size `n`. It offers flexible output options: print results to the console, save them to a file, or store them in memory.

## Features

- **Generate binary combinations**: For any size `n` (up to \(2^{16}\)).
- **Customizable characters**: Replace `0` and `1` with any other characters.
- **Output options**:
  - Print to the console.
  - Save to a file.
  - Store in an `ArrayList`.

---

## Requirements

- Java 8 or higher.

---

## How to Use

### Compile the Code
```bash
javac Combin.java
```

### Run the Program
```bash
java Combin <size> [bin0] [bin1] [filename] [console]
```

### Parameters
1. `<size>`: (Required) The size of the binary combinations. Must be a positive integer ≤ 16.
2. `[bin0]`: (Optional) Character to use instead of `0`.
3. `[bin1]`: (Optional) Character to use instead of `1`.
4. `[filename]`: (Optional) File to save the combinations. If provided, the program writes the combinations to this file.
5. `[console]`: (Optional) If provided and set to `console`, results are printed to the console.

---

## Examples

### Default Binary Output
Generate all binary combinations of size 3 and print them to the console:
```bash
java Combin 3 console
```

### Custom Characters
Generate combinations of size 3 using `X` and `Y` instead of `0` and `1`:
```bash
java Combin 3 X Y console
```

### Save to a File
Generate combinations of size 4 and save them to `output.txt`:
```bash
java Combin 4 0 1 output.txt
```

### Save and Print
Generate combinations of size 4, save them to `output.txt`, and also print them:
```bash
java Combin 4 0 1 output.txt console
```

---

## Error Handling
- **Invalid size**: If `<size>` is not provided, not a number, or exceeds the limit, an error is displayed.
- **Invalid characters**: Binary characters must be single characters.
- **File write issues**: Errors during file operations are logged to the console.

---

## Example Output

### Command:
```bash
java Combin 2 console
```

### Output:
```
Generating binary combinations for size: 2
Generated combinations:
00
01
10
11
```

---

## Author

- **Habis Muhammed**  
GitHub: [BrownCoatJustice](https://github.com/BrownCoatJustice)  

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.



