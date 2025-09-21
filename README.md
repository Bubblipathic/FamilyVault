# FamilyVault  

**Application for Safe and Secure Electronic Storage of Important Documents**  

FamilyVault simplifies accessing vital personal documents during emergencies. Securely store essential records digitally for quick access, ensuring convenience when physical copies are misplaced. Our user-friendly platform streamlines the process, offering a reliable and efficient means for families to manage and retrieve important documents in times of urgent need.  

---

## 🚀 Features  
- Secure storage of important family documents  
- Easy retrieval of files during emergencies  
- Organized database structure for family vaults, members, and files  
- PDF handling support via **Apache PDFBox**  
- User-friendly interface with **Java Swing GUI**  

---

## 🏗️ System Architecture  

- **Language:** Java  
- **IDE:** NetBeans IDE  
- **Front-end:** Javax Swing GUI  
- **Backend:** JDBC API  
- **External Tool:** Apache PDFBox  
- **Database:** Oracle  

![System Architecture](e62e015f-e7fd-4523-bf24-168e305ca71f.png)  

---

## 📂 Database Structure  

- **Family Vaults** → contains family information  
- **Family Members** → linked to vaults (1 to many)  
- **Files** → linked to members and vaults (1 to many)  

![Database Structure](00eb24c6-a768-4f73-9ed2-aacccaad02eb.png)  

---

## ⚙️ Installation & Setup  

### Option 1: Run JAR (Recommended)  
1. Navigate to the `dist/` folder  
2. Run the JAR file:  
   ```bash
   java -jar FamilyVault.jar
   ```

### Option 2: Build from Source  
1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/familyvault.git
   cd familyvault
   ```
2. Open the project in **NetBeans IDE**  
3. Configure database connection in JDBC to your **Oracle DB**  
4. Build and run the project  

---

## 📖 Usage  

1. Login or register a **Family Vault**  
2. Add family members and their details  
3. Upload and categorize important files  
4. Retrieve documents easily when needed  

---
