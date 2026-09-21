# 💸 Monthly Expense & Budget Analyzer

```text
               $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
               $                                                             $
               $    Monthly Expense & Budget Analyzer v2.0                   $
               $    --------------------------------------                   $
               $    [#] Income:    $6,500.00  [====================] 100%    $
               $    [-] Expenses:  $3,820.00  [============        ]  58%    $
               $    [+] Net Saved: $2,680.00  [========            ]  42%    $
               $                                                             $
               $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
```

> **Stop wondering where your money went—tell it where to go.**

Welcome to the **Monthly Expense & Budget Analyzer**, an intelligent, privacy-first tool designed to help you track spending, visualize financial leaks, and automate your budgeting strategy (50/30/20, Zero-Based, or Custom).

---

## 🌟 Features

* **⚡ Smart Transaction Tagging:** Automatically categorizes recurring bills, groceries, entertainment, and subscriptions.
* **🎯 Dynamic Budget Rules:** Supports 50/30/20 allocation (Needs, Wants, Savings), Zero-Based Budgeting, and custom savings goals.
* **📊 Visual Financial Reports:** Beautiful terminal outputs, interactive charts, and downloadable monthly PDF/CSV summaries.
* **🚨 Over-Budget Alerts:** Real-time warning system when spending approaches preset category limits.
* **🔒 Privacy-First Storage:** Local JSON or SQLite database—your financial data stays on your machine.

---

## 🚀 Quick Start

### 1. Installation

Clone the repository and set up your local environment:

```bash
# Clone repository
git clone https://github.com/your-username/budget-analyzer.git

# Navigate to folder
cd budget-analyzer

# Install dependencies
npm install   # or: pip install -r requirements.txt
```

---

### 2. Basic Setup & Usage

Initialize your base income and currency:

```bash
# Set monthly net income
npm run start init -- --income 5000 --currency USD
```

Log your transactions effortlessly:

```bash
# Add an expense
npm run start log -- --type expense --category "Groceries" --amount 142.50 --note "Weekly run"

# Add income
npm run start log -- --type income --category "Freelance" --amount 450.00 --note "Design project"
```

Generate your monthly summary report:

```bash
npm run start report -- --month current
```

---

## 📂 Project Architecture

```text
monthly-expense-budget-analyzer/
├── 📁 src/
│   ├── 📁 analytics/      # Budget rules engine & percentage calculations
│   ├── 📁 cli/            # Command-line interface & terminal formatting
│   ├── 📁 data/           # Local storage handlers (SQLite/JSON)
│   └── 📁 reports/        # Chart generator and PDF export logic
├── 📁 tests/              # Unit tests for financial logic
├── .env.example           # Configuration template
├── package.json           # Node.js dependencies & scripts
└── README.md              # Project documentation
```

---

## 🎨 Budgeting Frameworks Supported

| Framework | Needs | Wants | Savings / Debt | Best For |
| :--- | :---: | :---: | :---: | :--- |
| **50/30/20 Standard** | 50% | 30% | 20% | General wealth building |
| **Aggressive Saver** | 40% | 10% | 50% | FIRE movement, rapid payoff |
| **Zero-Based Budget** | Custom | Custom | Remainder | Total dollar control |

---

## 🤝 Contributing

Contributions are always welcome!

1. **Fork** the project
2. **Create** your feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

---

## 📜 License

Distributed under the **MIT License**. See `LICENSE` for details.