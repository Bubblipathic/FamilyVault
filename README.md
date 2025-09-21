# FamilyVault  

**Application for Electronic Storage of Important Documents**  

FamilyVault is a simple **locally stored** application for securely managing family documents.  
It lets families create a vault, add members, and upload files for quick offline access in times of need.  

---

## 🚀 Features  
- Secure storage of important family documents  
- Easy retrieval of files during emergencies  
- Organized database structure for family vaults, members, and files  
- PDF handling support via **Apache PDFBox**  
- User-friendly interface with **Java Swing GUI**  

---

## 🏗️ Tools

- **Language:** Java  
- **IDE:** NetBeans IDE  
- **Front-end:** Javax Swing GUI  
- **Backend:** JDBC API  
- **External Tool:** Apache PDFBox  
- **Database:** Oracle  


---

## 📂 Database Structure  

- **Family Vaults** → contains family information  
- **Family Members** → linked to vaults (1 to many)  
- **Files** → linked to members and vaults (1 to many)

---

## 📷 Frames

![Frame Screenshot](/Screenshots/Screenshot.png)  

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
   git clone https://github.com/Bubblipathic/FamilyVault.git
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
