Utility
=========

Validation Class for email, SSN, NPI strings
--------------------------------------------

This Utility Class will help you validating email strings, SSN, and NPI(both as Strings)

For email strings, the pattern is -

^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$

For SSN strings,

The rules by SSA listed here:

[Fact Sheet](http://www.ssa.gov/kc/SSAFactSheet--IssuingSSNs.pdf)

1. SSA will not issue SSNs beginning with the number “9”. Pattern Used: [0-8][\\d]{8}
2. SSA will not issue SSNs beginning with the number “666” in positions 1 – 3. Pattern Used: [6]{3}[\\d]{6}
3. SSA will not issue SSNs beginning with the number “000” in positions 1 – 3. Pattern Used: [0]{3}[\\d]{6}
4. SSA will not issue SSNs with the number “00” in positions 4 – 5. Pattern Used: [\\d]{5}[0]{4}
5. SSA will not issue SSNs with the number “0000” in positions 6 – 9. Pattern Used: [\\d]{3}[0]{2}[\\d]{4}

For NPI strings,

A National Provider Identifier or NPI is a unique 10-digit identification number issued to health care providers in the United States by the Centers for Medicare and Medicaid Services (CMS). This unique 10-digit number can be validated using Luhn algorithm which is cited here:

[CMS Check Digit](https://www.cms.gov/Regulations-and-Guidance/HIPAA-Administrative-Simplification/NationalProvIdentStand/downloads/NPIcheckdigit.pdf)

Luhn algorithm can be found here:

[Luhn Algorithm](http://en.wikipedia.org/wiki/Luhn_algorithm)